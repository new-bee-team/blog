package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 18:00
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserExperienceDTO implements Serializable {
    private Integer id;
    private Integer experience; //此次增加的经验值
    private Integer currentExperience; //当前的总经验值
    private String description; // 说明
    private Long time;
}
