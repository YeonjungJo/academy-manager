package zoe.academymanager.domain.room;

import lombok.*;
import zoe.academymanager.domain.EnableStatus;

import javax.persistence.*;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Long roomId;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EnableStatus enableStatus;
}
