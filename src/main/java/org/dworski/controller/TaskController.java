package org.dworski.controller;

import org.dworski.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes("priorities")
public class TaskController {

    @Autowired
    private MessageSource messageSource;

    private Map<Integer, Task> tasks = new LinkedHashMap<Integer, Task>();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String tasks(Model model) {
        model.addAttribute("tasks", tasks.values());
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, Locale locale) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("priorities", buildPrioritiesDictionary(locale));
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

    private Map<String, String> buildPrioritiesDictionary(Locale locale) {
        Map<String, String> priorities = new LinkedHashMap<String, String>();
        priorities.put("1", messageSource.getMessage("task.priority.high", null, locale));
        priorities.put("2", messageSource.getMessage("task.priority.medium", null, locale));
        priorities.put("3", messageSource.getMessage("task.priority.low", null, locale));
        return priorities;
    }
}
