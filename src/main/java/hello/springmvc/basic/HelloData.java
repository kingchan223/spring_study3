package hello.springmvc.basic;

import lombok.Data;

@Data /* == @Getter + @Setter + @ToString + @RequiredArgsConstructor */
public class HelloData{
    private String username;
    private int age;
}



