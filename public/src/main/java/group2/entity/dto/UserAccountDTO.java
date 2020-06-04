package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.04 18:04
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserAccountDTO implements Serializable {
    private Integer id;
    private String account;
    private String picture;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private Long registerTime;
}
