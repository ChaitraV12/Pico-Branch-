package Tablecreation.picobranchpico.PicoBranchDetails.Repository;


import Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO;
import Tablecreation.picobranchpico.PicoBranchDetails.Model.PicoBranchDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PicoBranchDetailsRepository extends JpaRepository<PicoBranchDetails,String> {
    List<PicoBranchDetails> findAllByIsDeletedAndBranchIdAndIdIsNot(int i, String branchId, String id);

    List<PicoBranchDetails> findAllByIsDeletedAndBranchId(int i, String branchId);

    List<PicoBranchDetails> findAllByIsDeleted(int isDeleted, Sort sort);

    Page<PicoBranchDetails> findAllByIsDeleted(int isDeleted, Pageable page);

    Page<PicoBranchDetails> findAll(Specification<PicoBranchDetails> textInAllColumns, Pageable pageable);



    @Query(
            "SELECT new Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
                    "picoBranchDetails.id, " +
                    "picoBranchDetails.clientId, " +
                    "picoBranchDetails.orgId, " +
                    "picoBranchDetails.branchId, " +
                    "picoBranchDetails.branchHeadId, " +
                    "picoBranchDetails.branchAdminId, " +
                    "picoBranchDetails.createdBy, " +
                    "picoBranchDetails.creationTime, " +
                    "picoBranchDetails.modifiedBy, " +
                    "picoBranchDetails.modificationTime, " +
                    "picoBranchDetails.isDeleted, " +
                    "picoBranchDetails.deletedBy, " +
                    "picoBranchDetails.deletionTime, " +
                    "picoBranch.name" +
                    " )" +
                    " FROM PicoBranchDetails as picoBranchDetails" +
                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id" +
                    " WHERE picoBranch.name LIKE:searchText AND picoBranchDetails.isDeleted=0 "
    )
    Page<PicoBranchDetailsDTO> searchPaginated(@Param("searchText") String searchText, Pageable pageable);

//    @Query(
//            "SELECT new Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
//                    "picoBranchDetails.id, " +
//                    "picoBranchDetails.clientId, " +
//                    "picoBranchDetails.orgId, " +
//                    "picoBranchDetails.branchId, " +
//                    "picoBranchDetails.branchHeadId, " +
//                    "picoBranchDetails.branchAdminId, " +
//                    "picoBranchDetails.createdBy, " +
//                    "picoBranchDetails.creationTime, " +
//                    "picoBranchDetails.modifiedBy, " +
//                    "picoBranchDetails.modificationTime, " +
//                    "picoBranchDetails.isDeleted, " +
//                    "picoBranchDetails.deletedBy, " +
//                    "picoBranchDetails.deletionTime, " +
//                    "picoBranch.name" +
//                    " )" +
//                    " FROM PicoBranchDetails as picoBranchDetails" +
//                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id" +
//                    "WHERE picoBranchDetails.isDeleted=0"
//    )
    List<PicoBranchDetailsDTO> findByIsDeleted(int isDeleted, Sort sort);

//    @Query(
//            "SELECT new Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
//                    "picoBranchDetails.id, " +
//                    "picoBranchDetails.clientId, " +
//                    "picoBranchDetails.orgId, " +
//                    "picoBranchDetails.branchId, " +
//                    "picoBranchDetails.branchHeadId, " +
//                    "picoBranchDetails.branchAdminId, " +
//                    "picoBranchDetails.createdBy, " +
//                    "picoBranchDetails.creationTime, " +
//                    "picoBranchDetails.modifiedBy, " +
//                    "picoBranchDetails.modificationTime, " +
//                    "picoBranchDetails.isDeleted, " +
//                    "picoBranchDetails.deletedBy, " +
//                    "picoBranchDetails.deletionTime, " +
//                    "picoBranch.name" +
//                    " )" +
//                    " FROM PicoBranchDetails as picoBranchDetails" +
//                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id" +
//                    "WHERE picoBranchDetails.isDeleted=1"
//    )
    List<PicoBranchDetailsDTO> findAllByIsDeleted(int isDeleted);
    @Query(
            "SELECT new Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
                    "picoBranchDetails.id, " +
                    "picoBranchDetails.clientId, " +
                    "picoBranchDetails.orgId, " +
                    "picoBranchDetails.branchId, " +
                    "picoBranchDetails.branchHeadId, " +
                    "picoBranchDetails.branchAdminId, " +
                    "picoBranchDetails.createdBy, " +
                    "picoBranchDetails.creationTime, " +
                    "picoBranchDetails.modifiedBy, " +
                    "picoBranchDetails.modificationTime, " +
                    "picoBranchDetails.isDeleted, " +
                    "picoBranchDetails.deletedBy, " +
                    "picoBranchDetails.deletionTime, " +
                    "picoBranch.name" +
                    " )" +
                    " FROM PicoBranchDetails as picoBranchDetails" +
                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id" +
                    " WHERE picoBranchDetails.id like :id "
    )
    Optional<PicoBranchDetailsDTO> findData(String id);
    @Query(
            "SELECT new Tablecreation.picobranchpico.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
                    "picoBranchDetails.id, " +
                    "picoBranchDetails.clientId, " +
                    "picoBranchDetails.orgId, " +
                    "picoBranchDetails.branchId, " +
                    "picoBranchDetails.branchHeadId, " +
                    "picoBranchDetails.branchAdminId, " +
                    "picoBranchDetails.createdBy, " +
                    "picoBranchDetails.creationTime, " +
                    "picoBranchDetails.modifiedBy, " +
                    "picoBranchDetails.modificationTime, " +
                    "picoBranchDetails.isDeleted, " +
                    "picoBranchDetails.deletedBy, " +
                    "picoBranchDetails.deletionTime, " +
                    "picoBranch.name" +
                    " )" +
                    " FROM PicoBranchDetails as picoBranchDetails" +
                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id"

    )
    PicoBranchDetailsDTO savePicoBranch(PicoBranchDetails picoBranchDetails);

}