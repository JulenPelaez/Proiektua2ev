package dambi.proiekto.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Planta {
    @Id 
    private ObjectId _id;
    private String name;
    private String img_url;
    private String type;
    private String thc_level;
    private String most_common_terpene;
    private String description;
    private Effects effects;
    
    public ObjectId get_id() {
        return _id;
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImg_url() {
        return img_url;
    }
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getThc_level() {
        return thc_level;
    }
    public void setThc_level(String thc_level) {
        this.thc_level = thc_level;
    }
    public String getMost_common_terpene() {
        return most_common_terpene;
    }
    public void setMost_common_terpene(String most_common_terpene) {
        this.most_common_terpene = most_common_terpene;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Effects getEffects() {
        return effects;
    }
    public void setEffects(Effects effects) {
        this.effects = effects;
    }
    
}
