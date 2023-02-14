package dao;

import models.Transport;

public interface ITransport extends IBaseDao<Transport> {
	Transport getEntityByType();
}
