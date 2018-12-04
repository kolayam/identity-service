package eu.nimble.core.infrastructure.identity.repository;

import eu.nimble.service.model.ubl.commonaggregatecomponents.PartyType;
import eu.nimble.service.model.ubl.commonaggregatecomponents.PersonType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Johannes Innerbichler on 25/04/17.
 * Repository for parties.
 */
//@RepositoryRestResource(collectionResourceRel = "party", path = "party-hal")
public interface PartyRepository extends PagingAndSortingRepository<PartyType, Long>, JpaSpecificationExecutor<PartyType> {

    List<PartyType> findByHjid(Long hijd);

    List<PartyType> findByPerson(PersonType person);

    @Query(value = "select hjid from document_reference_type where document_reference_party_typ_0 = ?1 and document_type = ?2",
            nativeQuery = true)
    List<BigInteger> findDocumentIds(Long companyId, String documentType);
}
