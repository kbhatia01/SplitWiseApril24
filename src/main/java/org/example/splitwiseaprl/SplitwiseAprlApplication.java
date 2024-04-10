package org.example.splitwiseaprl;

import Command.CommandExecutor;
import Command.SettleUpUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseAprlApplication implements CommandLineRunner {

    Scanner sc = new Scanner(System.in);
    CommandExecutor ce = new CommandExecutor();

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseAprlApplication.class, args);
    }


    public void fillCommands(){
        SettleUpUserCommand suc = new SettleUpUserCommand();
        ce.AddCommand(suc);
    }
    @Override
    public void run(String... args) throws Exception {
        fillCommands();
        while (true){
            String input = sc.nextLine();
            ce.execute(input);
        }

    }


    // settle up users
    // settle up groups
    // Command line

}
