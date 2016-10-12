package com.so.webblog.info;

import com.so.webblog.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author user
 */

public class UserSessionStorage {
    
    private static ConcurrentHashMap<User,Map<String, DeviceInfo>> userSessions = new ConcurrentHashMap<>();
    
    public static void addAuthentication(User user, String sessionId, DeviceInfo deviceInfo){
        Map userAuthorities = null;
        boolean isNew;
        if(userSessions.containsKey(user)){
            isNew = false;
            userAuthorities = userSessions.get(user);
        }else{
            isNew = true;
            userAuthorities = new HashMap();
            userAuthorities.put(sessionId, deviceInfo);
        }
        
        if(isNew){
            userSessions.put(user, userAuthorities);
        }else{
            userSessions.get(user).put(sessionId, deviceInfo);
        }
    }
    
    public static void removeAuthentication(User user, String sessionId){
        userSessions.get(user).remove(sessionId);
    }
    
    public static void removeAllAuthentications(User user){
        userSessions.clear();
    }
    
    public static DeviceInfo getUserOrigin(User user, String sessionId){
        return userSessions.get(user).get(sessionId);
    }
    
    public static Map getAllUserOrigins(User user){
        return userSessions.get(user);
    }
    
    public static boolean containsDeviceAuthentication(User user, String sessionId){
        if(!userSessions.contains(user)){
            return false;
        }
        return userSessions.get(user).containsKey(sessionId);
    }
}
