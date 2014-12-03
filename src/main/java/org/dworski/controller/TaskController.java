package org.dworski.controller;

import org.dworski.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SessionAttributes("priorities")
public class TaskController {

    private Map<Integer, Task> tasks = new LinkedHashMap<Integer, Task>();

    private static final Map<String, String> priorities = new LinkedHashMap<String, String>();

    public TaskController() {
        priorities.put("1", "High");
        priorities.put("2", "Medium");
        priorities.put("3", "Low");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String tasks(Model model) {
        model.addAttribute("tasks", tasks.values());
        model.addAttribute("priorities", priorities);
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null || id == 0 || !tasks.containsKey(id)) {
            return "redirect:/add";
        } else {
            Task task = tasks.get(id);
            model.addAttribute("task", task);
            return "edit";
        }

    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("task") Task task) {
        if (task.getId() == 0) {
            task.setId(tasks.size() + 1);
        }
        tasks.put(task.getId(), task);
        return "redirect:/";
    }
}
