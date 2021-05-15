package edu.sjsu.controller;

/**
 * This class distinguished the messages sent to the valve
 */
public enum ValveMessage {
    MISS, //Valve cannot process the message
    EXECUTED, //valve processed message
    FINISH //Closing enum
}
