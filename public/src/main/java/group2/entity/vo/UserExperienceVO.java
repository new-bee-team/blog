package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.04 17:59
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserExperienceVO implements Serializable {
    private Integer userId; //逻辑外键 用户id
    private Integer experience; //此次增加的经验值
    private String description; // 说明
}
