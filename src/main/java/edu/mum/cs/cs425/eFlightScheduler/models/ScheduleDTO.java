package edu.mum.cs.cs425.eFlightScheduler.models;

/**
 * Schedule DTO
 */
public class ScheduleDTO {

    private Long flightId;

    private String status;

    private String time;

    public ScheduleDTO(Long flightId, String status, String time) {
        this.flightId = flightId;
        this.status = status;
        this.time = time;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "flightId=" + flightId +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
