package randomdata.model;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public abstract class AbstractMyList {
    public List<BookAttach> bookAttachList;
    public List<BookType> bookTypeList;
    public List<Province> provinceList;
    public List<FamilyFirstName> familyNameList;
    public List<Publisher> publisherList;
    public List<University> universityList;
}
