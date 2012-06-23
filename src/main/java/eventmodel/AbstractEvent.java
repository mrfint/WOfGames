package eventmodel;

class AbstractEvent {
    private String request;

    private String response;



    public AbstractEvent(String request, String response) {

        this.request = request;

        this.response = response;

    }



    public String getRequest() {

        return request;

    }



    public String getResponse() {

        return response;
    }
        
}
