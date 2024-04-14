package Tablecreation.picobranchpico.PicoBranchDetails.Specification;

import Tablecreation.picobranchpico.PicoBranchDetails.Model.PicoBranchDetails;
import org.springframework.data.jpa.domain.Specification;


public class PicoBranchDetailsSpecification {
    public static Specification<PicoBranchDetails> TextAllcolumn(String searchtext) {
        if (!searchtext.contains("%")) {
            searchtext = "%" + searchtext + "%";

        }
        String finaltext = searchtext;
        return (root, query, builder) -> builder.and(builder.or(builder.like(root.get("name"), finaltext), builder.equal(root.get("isdelete"), 0)));
    }
}
