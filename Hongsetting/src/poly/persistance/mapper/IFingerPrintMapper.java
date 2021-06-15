package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.AttendDTO;
import poly.dto.BoardDTO;

@Mapper("FingerPrintMapper")
public interface IFingerPrintMapper {
	
	public int attend(AttendDTO aDTO) throws Exception;

	public List<AttendDTO> getData(AttendDTO aDTO) throws Exception;
}
