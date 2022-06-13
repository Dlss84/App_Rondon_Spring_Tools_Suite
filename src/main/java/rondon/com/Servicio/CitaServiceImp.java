package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rondon.com.Interfaz.ICita;
import rondon.com.Modelo.Cita;

@Service
public class CitaServiceImp implements CitaService{
		@Autowired
		private ICita repository;
		
		@Override
		public Collection<Cita> listarCita() {
			// TODO Auto-generated method stub
			return (Collection<Cita>) repository.findAll();
		}

		@Override
		@Transactional
		public void insertar(Cita Cita) {
			repository.save(Cita);
			
		}

		@Override
		@Transactional
		public void modificar(Cita Cita) {
			repository.save(Cita);		
			
		}
		

		@Override
		@Transactional
		public void eliminar(Integer citaId) {
			repository.deleteById(citaId); 
			
		}

		@Override
		@Transactional
		public Cita buscar(Integer citaId) {
			// TODO Auto-generated method stub
			return repository.findById(citaId).orElse(null);
		}
}
