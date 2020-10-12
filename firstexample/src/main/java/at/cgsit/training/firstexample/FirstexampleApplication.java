package at.cgsit.training.firstexample;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstexampleApplication {

  public static void main(String[] args) {

    //simple startup version
    //SpringApplication.run(FirstexampleApplication.class, args);

    SpringApplication app = new SpringApplication(FirstexampleApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);

  }

}
