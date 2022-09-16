package DTO;

import java.util.Date;

public class User {

    private static int idCounter = 0;

    private Integer id = null;
    private String name = null;
    private Integer run = null;
    private char dv = 0;
    private Date birthDate = null;
    private Integer phoneNum = null;
    private String email = null;
    private String username = null;
    private String password = null;

    public User User() {
        return this;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRun() {
        return run;
    }

    public char getDv() {
        return dv;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setRun(Integer run, char dv) {
        final String errorMessage = "run no valido";
        final boolean valid_run = Validation.validarRut(run, dv);
        if (!valid_run || run < 0  || dv < 0) {
            System.out.println(errorMessage);
            return false;
        }
        this.run = run;
        this.dv = dv;
        return true;
    }

    public boolean setBirthDate(String birthDate) {
        final String errorMessage = "Fecha invalida o eres menor de edad";
        final int secPYear = 60 * 60 * 24 * 365 * 18;

        if (!Validation.validateJavaDate(birthDate)) {
            System.out.println(errorMessage);
            return false;
        }

        Date birth = Validation.dateFromString(birthDate);

        if ((new Date()).getTime() - birth.getTime()  < secPYear) {
            System.out.println(errorMessage);
            return false;
        }

        this.birthDate = birth;
        return true;
    }

    public boolean setPhoneNum(Integer phoneNum) {
        final String errorMessage = "el numbero de telefono debe tener al menos 8"
                + " caracteres, y empezar con 56";

        String strNum = String.valueOf(phoneNum);
        if (strNum.length() < 8 || phoneNum < 0) {
            System.out.println(errorMessage);
            return false;
        }
        if (!strNum.substring(0, 2).equals("56")) {
            System.out.println(errorMessage);
            return false;
        };

        this.phoneNum = phoneNum;
        return true;
    }

    public boolean setEmail(String email) {
        final String errorMessage = "email invalido.";

        boolean isValid = Validation.isValidEmail(email);
        if (isValid) {
            this.email = email;
            return true;
        }
        System.out.println(errorMessage);
        return false;
    }

    public void setUsername(String username) {
        final String errorMessage = "el username debe tener al menos 4 caracteres";

        if (errorMessage.length() < 4) {
            System.out.println(errorMessage);
        }

        this.username = username;
    }

    public boolean setPassword(String password) {
        final String error_message = "Clave invalida, se requiere 1 mayuscula"
                + ", 1 numero y un largo minimo de 6 caracteres";
        final int size = password.length();
        if (size < 6) {
            System.out.println(error_message);
            return false;
        }

        boolean mayus = false, number = false;
        for (int i = 0; i < size; i++) {
            char val = password.charAt(i);
            if (Character.isUpperCase(val)) {
                mayus = true;
            }
            if (Character.isDigit(val)) {
                number = true;
            }
        }

        if (mayus && number) {
            this.password = password;
            return true;
        }

        System.out.println(error_message);
        return false;
    }

    public boolean validateLogin(String username, String passwd) {
        final String errorMessage = "Login fallido";

        if (!username.equals(this.username) || !passwd.equals(this.password)) {
            System.out.println(errorMessage);
            return false;
        }

        return true;
    }

    public String resetPassword() {
        this.password = "notRandomPassword123.." + this.username;
        return this.password;
    }

    public int getAge() {
        final int secPYear = 60 * 60 * 24 * 365 * 18;

        return (int) (((this.birthDate.getTime() - (new Date()).getTime()) / secPYear));
    }
}
