package com.learn.springboot2.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommonUtils {
public String localDateToDatabaseDate(LocalDateTime time) {
	return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a").format(time);
}
}
