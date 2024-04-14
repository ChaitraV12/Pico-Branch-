package Tablecreation.picobranchpico.PicoBranch.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class PicoBranch {
    @Id
    @Column(unique=true,length = 40)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="client_id",length = 40)
    private String clientId;


    @Column(name="org_id",length = 40)
    private String orgId;

    @Column(unique=true,length = 100)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name="created_by",length = 40)
    private String createdBy;

    @Column(name="creation_time",length = 100)
    private Date creationTime;


    @Column(name="modified_by",length = 40)
    private String modifiedBy;

    @Column(name="modification_time")
    private Date modificationTime;

    @Column(name="is_deleted")
    private int isDeleted;


    @Column(name="deleted_by",length = 40)
    private String deletedBy;

    @Column(name="deletion_time")
    private Date deletionTime;


}
