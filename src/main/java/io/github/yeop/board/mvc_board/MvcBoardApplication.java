package io.github.yeop.board.mvc_board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@MapperScan("io.github.yeop.board.mvc_board.repository.repositoryMapper")
public class MvcBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBoardApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

	//실행할때 자스피티 여기에 넣기
}