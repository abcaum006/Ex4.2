public abstract class Customer {
    public abstract String createMail();
    public abstract String createBrochure();

    public final String generateMail() {
        return "Customer Type: " + getClass().getSimpleName() + "\n" +
                createMail();
    }

    public final String generateBrochure() {
        return "Customer Type: " + getClass().getSimpleName() + "\n" +
                createBrochure();
    }
}