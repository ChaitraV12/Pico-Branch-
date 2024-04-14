package Tablecreation.picobranchpico.PicoBranch.Specification;

import Tablecreation.picobranchpico.PicoBranch.Model.PicoBranch;
import org.springframework.data.jpa.domain.Specification;


public class PicoBranchSpecification {
    public static Specification<PicoBranch> TextAllcolumn(String searchtext) {
        if (!searchtext.contains("%")) {
            searchtext = "%" + searchtext + "%";

        }
        String finaltext = searchtext;
        return (root, query, builder) -> builder.and(builder.or(builder.like(root.get("name"), finaltext), builder.equal(root.get("isdelete"), 0)));
    }
}
