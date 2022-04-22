package cz.denny.itccave;

import java.time.LocalDate;

/**
 * Insuree class extends person with an extended set of params
 */

public class Insuree extends Person{

    // Shall I add Person as an extra field here
    // private variables
    private int policyNo;          // add counter
    private String phoneNo = "";    // string for special symbols parse l8r - + #?
    private String policyType;      // Life, House, Car etc...
    private LocalDate policyStartDate;
    private String note;            // special records/notes


    public Insuree(){}
    public Insuree(LocalDate dayOfBirth){
        super(dayOfBirth);
    }
    public Insuree(String surname) {
        super(surname);
    }
    public Insuree(String name, String surname) {
        super(name, surname);
    }
    public Insuree(int personID, String name, String surname) {
        super(personID, name, surname);
    }
    public Insuree(int personID, String name, String surname, LocalDate date, String gender) {
        super(personID, name, surname, date, gender);
    }

    /**
     * Constructor for
     * @param personID      personID
     * @param name          Name
     * @param surname       Surname
     * @param dob           Day of Birth
     * @param phoneNo       Phone Number
     * @param policyType    Insurance Policy Type
     * @param policyStartDate Commencement Policy Day
     * @param note          Note
     */
    public Insuree(int personID, String name, String surname, LocalDate dob, String gender,
       /* added */ String phoneNo, String policyType, LocalDate policyStartDate, String note) {
        super(personID, name, surname, dob, gender);
        this.phoneNo = phoneNo;
//        this.policyNo = 0; //++lastPolicyNo;
        this.policyType = policyType;
        this.policyStartDate = policyStartDate;
        this.note = note;
    }

    //getters & setters
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getPolicyType() {
        return policyType;
    }
    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }
    public LocalDate getPolicyEndDate() {
        // based on type/price?
        return policyStartDate.plusYears(3);
    }
    public int getPolicyNo() {
        return policyNo;
    }
    public String getNote(){ return note; }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
    public void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
    }
//    public void setPolicyEndDate(LocalDate policyEndDate) {
//        this.policyEndDate = policyEndDate;
//    }
    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }
    public void setNote(String note){
        this.note = note;
    }

    /**
     * Override toString method using StringBuilder
     * @return Insuree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // creates a new instance of a stringBuilder (an option, no reason)
        sb.append(super.toString());            // super calls toString override method of a parent class (Person)
        sb.append("\n\t\t  ").append("Phone No.").append("=[").append(phoneNo).append("] ");
        sb.append("\n\t\t  ").append("Policy Type").append("=[").append(policyType).append("] ");
        sb.append("\n\t\t  ").append("Policy Start Date").append("=[").append(DateTimeUtils.FORMAT_DATE.format(policyStartDate)).append("] ");
        sb.append("\n\t\t  ").append("Policy End Date").append("=[").append(DateTimeUtils.FORMAT_DATE.format(getPolicyEndDate())).append("] ");
        sb.append("\n\t\t  ").append("Policy Number").append("=[").append(String.format("%08d", policyNo)).append("] ");  // cz.denny.itccave.Insurance Policy Unique Number
        sb.append("\n\t\t  ").append("Note").append("=[").append(note).append("]\n");
        return sb.toString();
    }
}
