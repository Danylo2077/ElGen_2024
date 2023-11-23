package com.elgen.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@EqualsAndHashCode
public class FollowerId implements Serializable {

    private Long user; // Идентификатор пользователя
    private Long follower_user_id;
    private Long follow_user_id; // Идентификатор пользователя-подписчика

}
