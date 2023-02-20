package mybatisdao;

import java.util.ArrayList;

import models.Transport;

public interface ITransportDAO {
	ArrayList<Transport> getAllTransports();
	Transport getTransport(long id);
}
