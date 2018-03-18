/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmessages;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bladt
 */
public class MessageFacade {

    private static Gson gson = new Gson();

    //This seemingly silly wrapper ensures that the object is a JSONMessage, proving that we intend to serialize it
    public static String messagetoJson(JSONMessage jm) {
        return gson.toJson(jm);
    }

    public static <T extends JSONMessage> T jsonToMessage(String json, Class<T> c) {
        return gson.fromJson(json, c);
    }
  
    public static <T2, T extends JSONMessage<T2>> T2 fromJson(String json, Class<T> DTOClass){
        return jsonToMessage(json, DTOClass).toInternal();
    }
    
/**
 * Old code form demo. 
 * The new fromJson delegates the logic to the JSONMessage subclass, and can hence be simple.
 * To go from entityX to json, we use the constructor of a XMessage class to get a message, and then we can use messageToJSON to get the json string.
    
    public static StudentEntity fromJson(String message){
        StudentMessage sm = gson.fromJson(message, StudentMessage.class);
        return new StudentEntity(sm.name, sm.studypoints,sm.id);
    }
    
    public static String toJson(StudentEntity se){
        List<String> cNames=new ArrayList<>();
        for (CourseEntity c : se.courses) {
            cNames.add(c.getCourseName());
        }
        StudentMessage sm = new StudentMessage(se.getName(), se.getStudypoints(), cNames, se.id);
        return gson.toJson(sm);
    }
*/
}
