package com.cisco.nesal.internal;

import java.util.Map;

import org.squirrelframework.foundation.fsm.*;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.*;
import org.squirrelframework.foundation.fsm.builder.*;

import com.cisco.nesal.internal.SimpleFSM.FSMEvent;
import com.cisco.nesal.internal.SimpleFSM.StateMachineSample;

public class FSM2 {

    public FSM2() {
        // TODO Auto-generated constructor stub
    }

    @States({
        @State(name="A", entryCallMethod="entryStateA", exitCallMethod="exitStateA"), 
        @State(name="B", entryCallMethod="entryStateB", exitCallMethod="exitStateB")
    })
    @Transitions({
        @Transit(from="A", to="B", on="GoToB", callMethod="stateAToStateBOnGotoB"),
        @Transit(from="A", to="A", on="WithinA", callMethod="stateAToStateAOnWithinA", type=TransitionType.INTERNAL)
    })
    
    
    interface MyStateMachine extends StateMachine<MyStateMachine, String, String, String> {
        void entryStateA(String from, String to, String event, String context);
        void stateAToStateBOnGotoB(String from, String to, String event, String context);
        void stateAToStateAOnWithinA(String from, String to, String event, String context);
        void exitStateA(String from, String to, String event, String context);
        
    }
    
    public static class MyStateMachineImpl 
        extends AbstractStateMachine<MyStateMachine, String, String, String> 
        implements MyStateMachine {

        private final MyStateMachine monitor;

        protected MyStateMachineImpl(
                ImmutableState<MyStateMachine, String, String, String> initialState,
                Map<String, ImmutableState<MyStateMachine, String, String, String>> states,
                MyStateMachine delegator) {
            super(initialState, states);
            this.monitor = delegator;
        }
        
        @Override
        public void entryStateA(String from, String to, String event,
                String context) {
            System.out.println("-> in entryStateA");
            
        }

        @Override
        public void stateAToStateBOnGotoB(String from, String to, String event,
                String context) {
            System.out.println("-> in stateAToStateBOnGotoB");
            
        }

        @Override
        public void stateAToStateAOnWithinA(String from, String to,
                String event, String context) {
            System.out.println("-> in stateAToStateAOnWithinA");
                        
        }

        @Override
        public void exitStateA(String from, String to, String event,
                String context) {
            System.out.println("-> in exitStateA");
                       
        }
        
        public static void main(String[] args) {
            StateMachineBuilder<MyStateMachine, String, String, String> builder =
                    StateMachineBuilderFactory.<MyStateMachine, String, String, String>
                        create(MyStateMachineImpl.class, String.class,
                                String.class, String.class, MyStateMachine.class);
            MyStateMachine stateMachine = builder.newStateMachine("A");
            
            System.out.println("Current state is "+ stateMachine.getCurrentState());
        }

    }

    
    
}
