package DTO;

public class Club {
    static int codeCounter = 10;
    
    private String code;
    private String name;
    private String founderName;
    private int foundationYear;
    private String country;
    private String motto;
    private String colors;
    private Integer valueSub;

    public Club() {
    }

    public String getCode() {
        return code;
    }

    public void setCode() {
        this.code = this.name.substring(0,2);
        this.code += 'H';
        this.code += codeCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getValueSub() {
        return valueSub;
    }

    public void setValueSub(Integer valueSub) {
        this.valueSub = valueSub;
    }
}
