package mybatisdao;

import java.util.ArrayList;

import models.Transport;

public interface ITransportDAO {
	ArrayList<Transport> getAllTransports();
	Transport getTransport(long id);
	public void create(Transport transport);
	public void update(Transport transport);
	public void delete(Transport transport);
}
