package com.tools.qa.util;

public class ApiHelper {

    public static boolean ScriptStateReturn(String state)
    {
        boolean scriptState = true;
        try
        {
            if(state.trim().equalsIgnoreCase("[Not]"))
                scriptState = false;
            else if(state.trim().equalsIgnoreCase("[Yes]")){
                scriptState = true;
            }
        }catch(NullPointerException e)
        {
            scriptState = true;
        }
        return scriptState;
    }
}
