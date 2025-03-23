/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Serva
 */
public class Blackboard {
    private Map<String, Object> data;
    private List<KnowledgeSource> knowledgeSources;

    public Blackboard() {
        data = new HashMap<>();
        knowledgeSources = new ArrayList<>();
    }

    public void set(String key, Object value) {
        data.put(key, value);
        notifyKnowledgeSources();
    }

    public Object get(String key) {
        return data.get(key);
    }

    public void addKnowledgeSource(KnowledgeSource ks) {
        knowledgeSources.add(ks);
    }

    private void notifyKnowledgeSources() {
        for (KnowledgeSource ks : knowledgeSources) {
            ks.update(this);
        }
    }
}
