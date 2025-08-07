public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String newEmailAddress) {
        this.emailAddress = newEmailAddress;
    }

    public boolean isValid() throws InvalidEmailFormatException {
        String regex = "^[a-zA-Z0-9._]+@company\\.com$";
        if (!emailAddress.matches(regex)) {
            throw new InvalidEmailFormatException("Please enter a valid Email Address " + this.emailAddress);
        }
        return true;
    }

    @Override
    public String toString() {
        return this.emailAddress;
    }
}