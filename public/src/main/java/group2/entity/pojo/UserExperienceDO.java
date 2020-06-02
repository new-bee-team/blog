package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 14:16
 * @description: 用户经验详细表
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserExperienceDO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private Integer experience; //此次增加的经验值
    private Integer currentExperience; //当前的总经验值
    private String description; // 说明
    private Long time;
}
