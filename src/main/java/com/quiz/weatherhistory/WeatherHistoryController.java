package com.quiz.weatherhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weatherhistory.bo.WeatherHistoryBO;
import com.quiz.weatherhistory.domain.WeatherHistory;

@RequestMapping("weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistory", weatherHistory);
		return "weatherHistory/weatherList";
	}
}
