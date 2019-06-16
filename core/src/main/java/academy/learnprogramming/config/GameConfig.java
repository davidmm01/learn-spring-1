package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig {

    // fields
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:-1}")
    private int minNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // when the above properties are found, notice they are logged
    // the numbers after the colon in @Value are defaults, avoids exception if a property isn't set

    // bean methods
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

}
