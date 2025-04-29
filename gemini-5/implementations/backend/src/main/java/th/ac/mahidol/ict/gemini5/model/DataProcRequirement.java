package th.ac.mahidol.ict.gemini5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "data_proc_requirement")
public class DataProcRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileType;
    private String fileQuality;
    private String colorType;
    private double contrast;
    private double brightness;
    private double saturation;
    private double highlights;
    private double exposure;
    private double shadows;
    private double whites;
    private double blacks;
    private double luminance;
    private double hue;

    public DataProcRequirement() {}

    public String getFileType() { 
        return fileType; 
    }
    public void setFileType(String fileType) { 
        this.fileType = fileType; 
    }

    public String getFileQuality() { 
        return fileQuality; 
    }
    public void setFileQuality(String fileQuality) { 
        this.fileQuality = fileQuality; 
    }

    public String getColorType() { 
        return colorType; 
    }
    public void setColorType(String colorType) { 
        this.colorType = colorType; 
    }

    public double getContrast() { 
        return contrast; 
    }
    public void setContrast(double contrast) { 
        this.contrast = contrast; 
    }

    public double getBrightness() { 
        return brightness; 
    }
    public void setBrightness(double brightness) { 
        this.brightness = brightness; 
    }

    public double getSaturation() { 
        return saturation; 
    }
    public void setSaturation(double saturation) { 
        this.saturation = saturation; 
    }

    public double getHighlights() { 
        return highlights; 
    }
    public void setHighlights(double highlights) { 
        this.highlights = highlights; 
    }
    
    public double getExposure() { 
        return exposure; 
    }
    public void setExposure(double exposure) { 
        this.exposure = exposure; 
    }

    public double getShadows() { 
        return shadows; 
    }
    public void setShadows(double shadows) { 
        this.shadows = shadows; 
    }

    public double getWhites() { 
        return whites; 
    }
    public void setWhites(double whites) { 
        this.whites = whites; 
    }

    public double getBlacks() { 
        return blacks; 
    }
    public void setBlacks(double blacks) { 
        this.blacks = blacks; 
    }

    public double getLuminance() { 
        return luminance; 
    }
    public void setLuminance(double luminance) { 
        this.luminance = luminance; 
    }

    public double getHue() { 
        return hue; 
    }
    public void setHue(double hue) { 
        this.hue = hue; 
    }

    public boolean isValid() {
        return fileType != null && !fileType.trim().isEmpty()
            && fileQuality != null && !fileQuality.trim().isEmpty()
            && colorType != null && !colorType.trim().isEmpty()
            && contrast >= 0 && contrast <= 100
            && brightness >= 0 && brightness <= 100
            && saturation >= 0 && saturation <= 100
            && highlights >= 0 && highlights <= 100
            && exposure >= 0 && exposure <= 100
            && shadows >= 0 && shadows <= 100
            && whites >= 0 && whites <= 100
            && blacks >= 0 && blacks <= 100
            && luminance >= 0 && luminance <= 100
            && hue >= 0 && hue <= 360;
    }
}
