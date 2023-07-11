package imageEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Entity
@Table(name = "ImageData")
@AllArgsConstructor
@Builder
public class ImageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Name;
	
	private String type;
	@Lob
	@Column(name = "imagedata",length=1000)
	private byte[] imageData;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public ImageEntity(String name, String type, byte[] imageData) {
		super();
		Name = name;
		this.type = type;
		this.imageData = imageData;
	}
	public ImageEntity() {
		super();
	}
	
	
}
