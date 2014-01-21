package com.cisco.nesal.internal;

import java.util.Map;

import org.squirrelframework.foundation.fsm.*;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.*;
import org.squirrelframework.foundation.fsm.builder.*;

import com.cisco.nesal.internal.SimpleFSM.FSMEvent;
import com.cisco.nesal.internal.SimpleFSM.StateMachineSample;

public class FSM {

    public FSM() {
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
        extends AbstractUntypedStateMachine {


        protected MyStateMachineImpl(ImmutableUntypedState initialState, 
                Map<Object, ImmutableUntypedState> states) {
            super(initialState, states);
        }
      
        public void entryStateA(String from, String to, String event,
                String context) {
            System.out.println("-> in entryStateA");
            
        }

        public void stateAToStateBOnGotoB(String from, String to, String event,
                String context) {
            System.out.println("-> in stateAToStateBOnGotoB");
            
        }

        public void stateAToStateAOnWithinA(String from, String to,
                String event, String context) {
            System.out.println("-> in stateAToStateAOnWithinA");
                        
        }

        public void exitStateA(String from, String to, String event,
                String context) {
            System.out.println("-> in exitStateA");
                       
        }
        
        public static void main(String[] args) {
           UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(MyStateMachineImpl.class);
           UntypedStateMachine stateMachine = builder.newStateMachine("A");
            
            System.out.println("Current state is "+ stateMachine.getCurrentState());
        }

    }

    
    
}
