package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "batch")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BatchEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batchId;

    @Column(name = "name", nullable = false, length = 50)
    private String batchName;

    @OneToMany(mappedBy = "batchEntity", targetEntity = StudentEntity.class)
    @Transient
    private List<StudentEntity> studentEntities;

}
