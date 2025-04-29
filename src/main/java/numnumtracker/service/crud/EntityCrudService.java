package numnumtracker.service.crud;

public interface EntityCrudService<
        AddRequest, GetRequest, UpdateRequest, DeleteRequest,
        AddResponse, GetResponse, UpdateResponse, DeleteResponse> {

    AddResponse add(AddRequest request);
    GetResponse get(GetRequest request);
    UpdateResponse update(UpdateRequest request);
    DeleteResponse delete(DeleteRequest request);
}
