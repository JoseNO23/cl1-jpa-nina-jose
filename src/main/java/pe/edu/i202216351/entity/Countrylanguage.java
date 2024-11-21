package pe.edu.i202216351.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countryLanguage")
public class Countrylanguage {
    @Id
    private String CountryCode;
    private String Language;
    @Enumerated(EnumType.STRING)
    private isOfficial isOfficial;
    private double Percentage;

    public enum isOfficial {
        T, F
    }

    public Countrylanguage() {
    }

    public Countrylanguage(String countryCode, String language, Countrylanguage.isOfficial isOfficial, double percentage) {
        CountryCode = countryCode;
        Language = language;
        this.isOfficial = isOfficial;
        Percentage = percentage;
    }

    @Override
    public String toString() {
        return "Countrylanguage{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", isOfficial=" + isOfficial +
                ", Percentage=" + Percentage +
                '}';
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public Countrylanguage.isOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Countrylanguage.isOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double percentage) {
        Percentage = percentage;
    }
}
