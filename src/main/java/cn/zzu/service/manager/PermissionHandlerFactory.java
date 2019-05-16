package cn.zzu.service.manager;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PermissionHandlerFactory {
    private Map<Integer, PermissionHandler> handlerMap = new HashMap<Integer, PermissionHandler>();

    public void register(Integer applicaType, PermissionHandler handler) {
        handlerMap.put(applicaType, handler);
    }

    public PermissionHandler getTaskHandler(Integer applicaType) {
        return (PermissionHandler)  handlerMap.get(applicaType);
    }

}
