package com.rest.criteriaquery.api.utilities;

import com.rest.criteriaquery.api.mapper.BaseMapper;
import com.rest.criteriaquery.api.search.dto.base.BasePageDTO;
import org.springframework.data.domain.Page;

/**
 * A set of utility functions for return entities consistently
 * and validating common fields
 */
public class EntityUtilities {

    /**
     * Converts an entityPage to a pageDTO
     *
     * @param entityPage         Entity page containing result data
     * @param pageDTO            Empty pageDTO of the desired output type
     *                           which is populated with the results from
     *                           the entityPage
     * @param mapperInstance     Instance of mapper for entity/dto type
     * @param verifiedSortColumn Field that is sorted upon
     * @param verifiedSortOrder  Whether sorting is ascending or descending
     * @param pluralResourceName Plural name of the resource the entity class
     *                           represents
     * @param <Entity>           Entity type
     * @param <DTO>              DTO type
     * @param <PageDTO>          PageDTO type
     * @param <Mapper>           Mapper Type
     * @return Returns pageDTO populated with the results of the entity page
     */
    public static <Entity,
            DTO,
            PageDTO extends BasePageDTO<DTO>,
            Mapper extends BaseMapper<DTO, Entity>>
    PageDTO transferToPageDTO(
            Page<Entity> entityPage,
            PageDTO pageDTO,
            Mapper mapperInstance,
            String verifiedSortColumn,
            String verifiedSortOrder,
            String pluralResourceName) {

        pageDTO.setHasContent(entityPage.hasContent());
        pageDTO.setHasNext(entityPage.hasNext());
        pageDTO.setHasPrevious(entityPage.hasPrevious());
        pageDTO.setFirst(entityPage.isFirst());
        pageDTO.setLast(entityPage.isLast());

        pageDTO.setTotalElements(entityPage.getTotalElements());

        pageDTO.setTotalPages(entityPage.getTotalPages());

        pageDTO.setData(
                mapperInstance.toDtoList(entityPage.toList())
        );

        pageDTO.setPerPage(entityPage.getSize());
        pageDTO.setPageNumber(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());

        pageDTO.setPluralResourceName(pluralResourceName);

        if (verifiedSortOrder != null && !verifiedSortOrder.equals("")
                && verifiedSortColumn != null && !verifiedSortColumn.equals("")) {
            pageDTO.setSortOrder(verifiedSortOrder);
            pageDTO.setSortColumn(verifiedSortColumn);
            pageDTO.setSorted(true);
        }

        return pageDTO;
    }
}
