package com.cisco.nesal.agent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.squirrelframework.foundation.exception.TransitionException;
import org.squirrelframework.foundation.fsm.Conditions.AbstractCondition;
import org.squirrelframework.foundation.fsm.ImmutableState;
import org.squirrelframework.foundation.fsm.StateMachine;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineLogger;
import org.squirrelframework.foundation.fsm.StateMachineStatus;
import org.squirrelframework.foundation.fsm.TransitionPriority;
import org.squirrelframework.foundation.fsm.TransitionType;
import org.squirrelframework.foundation.fsm.annotation.LogExecTime;
import org.squirrelframework.foundation.fsm.annotation.State;
import org.squirrelframework.foundation.fsm.annotation.States;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;


/**
 * This test case will ensure the underlying FSM framework works.
 */
public class FSMTest extends AbstractSFMTest {
    
    // 1. Define constants of states in the FSM.
    //
    public enum FSMTestState {
        A, B, C, D, E, Final
    }

    // 2. Define constants of transition event in the FSM.
    //
    public enum FSMTestEvent {
        Started,       
        ToEnd, ToA, InternalA, ToB, ToC, ToD,        
        Finished,      
        Terminated
    }

    // 3. Define the states and transitions of the FSM using declarative form.
    //
    @States({
        @State(name="A", entryCallMethod="entryStateA", exitCallMethod="exitStateA"), 
        @State(name="B", entryCallMethod="entryStateB", exitCallMethod="exitStateB"),
        @State(name="C", alias="StateC"),
        @State(name="D", entryCallMethod="entryStateD", exitCallMethod="exitStateD")
    })
    @Transitions({
        @Transit(from="A", to="B", on="ToB", callMethod="fromStateAToStateBOnGotoB"),
        @Transit(from="A", to="A", on="InternalA", callMethod="fromStateAToStateAOnInternalA", type=TransitionType.INTERNAL),
        @Transit(from="B", to="D", on="ToC"),
        @Transit(from="B", to="#StateC", on="ToC", priority=TransitionPriority.HIGH),
        @Transit(from="C", to="D", on="ToD", when=ExcellentCondition.class),
        @Transit(from="C", to="D", on="ToD", whenMvel="FailedCondition:::(context!=null && context>=0 && context<60)"),
        @Transit(from="D", to="A", on="ToA", callMethod="transitionWithException"),
        @Transit(from="D", to="Final", on="ToEnd", callMethod="fromStateDToFinalOnToEnd", isTargetFinal=true)
    })
    
    // 
    interface DeclarativeStateMachine extends StateMachine<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer> {
        // entry states
        void entryStateA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void entryStateB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void entryC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void entryStateD(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);

        // transitions
        void fromStateAToStateBOnGotoB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void fromStateAToStateAOnInternalA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void transitFromBToCOnToC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void transitFromCToDOnToDWhenExcellentCondition(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void transitFromCToDOnToDWhenFailedCondition(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void transitionWithException(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void fromStateDToFinalOnToEnd(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);

        // exit states
        void exitStateA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void exitStateB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void exitC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void exitStateD(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);

        void beforeTransitionBegin(FSMTestState from, FSMTestEvent event, Integer context);
        void afterTransitionCompleted(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context);
        void afterTransitionDeclined(FSMTestState from, FSMTestEvent event, Integer context);
        void afterTransitionCausedException(TransitionException e, FSMTestState fromState, 
                FSMTestState toState, FSMTestEvent event, Integer context);

        void start(Integer context);
        void terminate(Integer context);
    }

    static class ExcellentCondition extends AbstractCondition<Integer> {
        @Override
        public boolean isSatisfied(Integer context) {
            return context!=null && context>80;
        }
    }

    @SuppressWarnings("serial")
    static class DeclarativeStateMachineException extends RuntimeException {
    }

    private static class DeclarativeStateMachineImpl extends AbstractStateMachine<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer> implements DeclarativeStateMachine {
        private final DeclarativeStateMachine monitor;

        protected DeclarativeStateMachineImpl(
                ImmutableState<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer> initialState,
                Map<FSMTestState, ImmutableState<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer>> states,
                DeclarativeStateMachine delegator) {
            super(initialState, states);
            this.monitor = delegator;
        }

        @Override
        public void entryStateA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.entryStateA(from, to, event, context);
        }

        @Override
        public void entryStateB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.entryStateB(from, to, event, context);
        }

        @Override
        public void entryC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.entryC(from, to, event, context);
        }

        @Override
        public void entryStateD(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.entryStateD(from, to, event, context);
        }

        @Override
        public void fromStateAToStateBOnGotoB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.fromStateAToStateBOnGotoB(from, to, event, context);
        }

        @Override
        public void fromStateAToStateAOnInternalA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.fromStateAToStateAOnInternalA(from, to, event, context);
        }

        @Override
        @LogExecTime
        public void transitFromBToCOnToC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.transitFromBToCOnToC(from, to, event, context);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("How dare you to wake me up?");
            }
        }

        @Override
        public void transitFromCToDOnToDWhenExcellentCondition(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.transitFromCToDOnToDWhenExcellentCondition(from, to, event, context);
        }

        @Override
        public void transitionWithException(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.transitionWithException(from, to, event, context);
            throw new IllegalArgumentException("This exception is thrown on purpose.");
        }

        @Override
        public void fromStateDToFinalOnToEnd(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.fromStateDToFinalOnToEnd(from, to, event, context);
        }

        @Override
        public void exitStateA(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.exitStateA(from, to, event, context);
        }

        @Override
        public void exitStateB(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.exitStateB(from, to, event, context);
        }

        @Override
        public void exitC(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.exitC(from, to, event, context);
        }

        @Override
        public void exitStateD(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.exitStateD(from, to, event, context);
        }

        @Override
        public void beforeTransitionBegin(FSMTestState from, FSMTestEvent event, Integer context) {
            super.beforeTransitionBegin(from, event, context);
            monitor.beforeTransitionBegin(from, event, context);
        }

        @Override
        public void afterTransitionCompleted(FSMTestState from, FSMTestState to, FSMTestEvent event, Integer context) {
            super.afterTransitionCompleted(from, to, event, context);
            monitor.afterTransitionCompleted(from, to, event, context);
        }

        @Override
        public void afterTransitionDeclined(FSMTestState from, FSMTestEvent event, Integer context) {
            super.afterTransitionDeclined(from, event, context);
            monitor.afterTransitionDeclined(from, event, context);
        }

        @Override
        public void afterTransitionCausedException(TransitionException e, FSMTestState fromState, 
                FSMTestState toState, FSMTestEvent event, Integer context) {
            if(e.getTargetException().getMessage().equals("This exception is thrown on purpose.")) 
                return;
            super.afterTransitionCausedException(e, fromState, toState, event, context);
        }

        @Override
        public void start(Integer context) {
            super.start(context);
            monitor.start(context);
        }

        @Override
        public void terminate(Integer context) {
            super.terminate(context);
            monitor.terminate(context);
        }

        @Override
        public void transitFromCToDOnToDWhenFailedCondition(FSMTestState from,
                FSMTestState to, FSMTestEvent event, Integer context) {
            monitor.transitFromCToDOnToDWhenFailedCondition(from, to, event, context);
        }
    }

    @Mock 
    private DeclarativeStateMachine monitor;

    private DeclarativeStateMachine stateMachine;
    
    /**
     * Initializes a test.
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        StateMachineBuilder<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer> builder = 
                StateMachineBuilderFactory.<DeclarativeStateMachine, FSMTestState, FSMTestEvent, Integer>
                    create(DeclarativeStateMachineImpl.class, FSMTestState.class, 
                            FSMTestEvent.class, Integer.class, DeclarativeStateMachine.class);
        stateMachine = builder.newStateMachine(FSMTestState.A, monitor);
        StateMachineLogger fsmLogger = new StateMachineLogger(stateMachine);
        fsmLogger.startLogging();
    }

    @Test
    public void testInternalTransition() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.InternalA, null);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.A, FSMTestEvent.InternalA, null);
        callSequence.verify(monitor, Mockito.times(0)).exitStateA(
                FSMTestState.A, null, FSMTestEvent.InternalA, null);
        callSequence.verify(monitor, Mockito.times(1)).fromStateAToStateAOnInternalA(
                FSMTestState.A, FSMTestState.A, FSMTestEvent.InternalA, null);
        callSequence.verify(monitor, Mockito.times(0)).entryStateA(
                null, FSMTestState.A, FSMTestEvent.InternalA, null);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.A, FSMTestState.A, FSMTestEvent.InternalA, null);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.A));
    }

    @Test
    public void testExternalTransition() {
        InOrder callSequence = Mockito.inOrder(monitor);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.A));
        stateMachine.fire(FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.A, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).exitStateA(
                FSMTestState.A, null, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).fromStateAToStateBOnGotoB(
                FSMTestState.A, FSMTestState.B, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).entryStateB(
                null, FSMTestState.B, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.A, FSMTestState.B, FSMTestEvent.ToB, null);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.B));
    }

    @Test
    public void testDeclinedTransition() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, null);
        stateMachine.fire(FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.B, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(0)).exitStateB(
                FSMTestState.B, null, FSMTestEvent.ToB, null);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionDeclined(
                FSMTestState.B, FSMTestEvent.ToB, null);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.B));
    }

    @Test
    public void testInvokeExtensionMethod() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, null);
        stateMachine.fire(FSMTestEvent.ToC, null);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.B, FSMTestEvent.ToC, null);

        callSequence.verify(monitor, Mockito.times(1)).exitStateB(
                FSMTestState.B, null, FSMTestEvent.ToC, null);
        callSequence.verify(monitor, Mockito.times(1)).transitFromBToCOnToC(
                FSMTestState.B, FSMTestState.C, FSMTestEvent.ToC, null);
        callSequence.verify(monitor, Mockito.times(1)).entryC(
                null, FSMTestState.C, FSMTestEvent.ToC, null);

        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.B, FSMTestState.C, FSMTestEvent.ToC, null);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.C));
    }

    @Test
    public void testConditionTransition() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, null);
        stateMachine.fire(FSMTestEvent.ToC, null);
        stateMachine.fire(FSMTestEvent.ToD, -10);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.C, FSMTestEvent.ToD, -10);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionDeclined(
                FSMTestState.C, FSMTestEvent.ToD, -10);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.C));

        stateMachine.fire(FSMTestEvent.ToD, 81);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.C, FSMTestEvent.ToD, 81);
        callSequence.verify(monitor, Mockito.times(1)).exitC(
                FSMTestState.C, null, FSMTestEvent.ToD, 81);
        callSequence.verify(monitor, Mockito.times(1)).transitFromCToDOnToDWhenExcellentCondition(
                FSMTestState.C, FSMTestState.D, FSMTestEvent.ToD, 81);
        callSequence.verify(monitor, Mockito.times(1)).entryStateD(
                null, FSMTestState.D, FSMTestEvent.ToD, 81);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.C, FSMTestState.D, FSMTestEvent.ToD, 81);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.D));
    }
    
    @Test
    public void testConditionMvelTransition() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, null);
        stateMachine.fire(FSMTestEvent.ToC, null);

        stateMachine.fire(FSMTestEvent.ToD, 41);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.C, FSMTestEvent.ToD, 41);
        callSequence.verify(monitor, Mockito.times(1)).exitC(
                FSMTestState.C, null, FSMTestEvent.ToD, 41);
        callSequence.verify(monitor, Mockito.times(1)).transitFromCToDOnToDWhenFailedCondition(
                FSMTestState.C, FSMTestState.D, FSMTestEvent.ToD, 41);
        callSequence.verify(monitor, Mockito.times(1)).entryStateD(
                null, FSMTestState.D, FSMTestEvent.ToD, 41);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.C, FSMTestState.D, FSMTestEvent.ToD, 41);
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.D));
    }

    @Test
    public void testTransitionWithException() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, null);
        stateMachine.fire(FSMTestEvent.ToC, null);
        stateMachine.fire(FSMTestEvent.ToD, 81);

        stateMachine.fire(FSMTestEvent.ToA, 50);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.D, FSMTestEvent.ToA, 50);
        callSequence.verify(monitor, Mockito.times(1)).exitStateD(
                FSMTestState.D, null, FSMTestEvent.ToA, 50);
        callSequence.verify(monitor, Mockito.times(1)).transitionWithException(
                FSMTestState.D, FSMTestState.A, FSMTestEvent.ToA, 50);
        
        assertThat(stateMachine.getCurrentState(), equalTo(FSMTestState.D));
    }

    @Test
    public void testTransitToFinalState() {
        InOrder callSequence = Mockito.inOrder(monitor);
        stateMachine.fire(FSMTestEvent.ToB, 0);
        callSequence.verify(monitor, Mockito.times(1)).start(0);
        stateMachine.fire(FSMTestEvent.ToC, null);
        stateMachine.fire(FSMTestEvent.ToD, 81);

        stateMachine.fire(FSMTestEvent.ToEnd, -1);
        callSequence.verify(monitor, Mockito.times(1)).beforeTransitionBegin(
                FSMTestState.D, FSMTestEvent.ToEnd, -1);
        callSequence.verify(monitor, Mockito.times(1)).exitStateD(
                FSMTestState.D, null, FSMTestEvent.ToEnd, -1);
        callSequence.verify(monitor, Mockito.times(1)).fromStateDToFinalOnToEnd(
                FSMTestState.D, FSMTestState.Final, FSMTestEvent.ToEnd, -1);
        callSequence.verify(monitor, Mockito.times(1)).afterTransitionCompleted(
                FSMTestState.D, FSMTestState.Final, FSMTestEvent.ToEnd, -1);
        callSequence.verify(monitor, Mockito.times(1)).terminate(-1);
        assertThat(stateMachine.getStatus(), equalTo(StateMachineStatus.TERMINATED));
    }
}
