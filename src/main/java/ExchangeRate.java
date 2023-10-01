import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    public ExchangeRate(String base, Date date, Map<String, Double> rates, boolean success, Timestamp timestamp) {
        this.base = base;
        this.date = date;
        this.rates = rates;
        this.success = success;
        this.timestamp = timestamp;
    }

    public ExchangeRate() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private String base;

    private Date date;
    private Map<String, Double> rates;
    private boolean success;
    private Timestamp timestamp;
}
