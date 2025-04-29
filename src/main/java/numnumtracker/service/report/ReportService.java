package numnumtracker.service.report;

public interface ReportService<RequestType, ResponseType> {
    ResponseType getReport(RequestType request);
}
