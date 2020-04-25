package prog2.contacts;

/**
 * <p>Illustreert het gebruik van een zogenaamde 'fluent' API .</p>
 * <p>
 * <p>Deze klasse wordt als volgt gebruikt:</p>
 * <ul>
 * <li>Vraag een nieuwe {@link PersonFinder} op bij de {@link DataAccessContext}. Deze finder legt geen restricties
 * op aan wat er moet gezocht worden en kan dus bijvoorbeeld gebruikt worden voor een lijst van <i>alle</i> personen. </li>
 * <li>Roep één of meerdere van de {@code where}-methoden op om verdere restricties op te leggen. </li>
 * <li>Roep tenslotte één van de {@code get}-methoden op om de bijbehorende resultaten op te vragen.</li>
 * </ul>
 * <p>Dit kan ook allemaal in één oproep. Bijvoorbeeld:</p>
 * <pre>
 *     Iterable&lt;Person&gt; persons
 *          = context.findPersons()
 *                   .whereNameStartsWith("C")
 *                   .whereFirstNameStartsWith("K")
 *                   .getList();
 * </pre>
 * <p><b>Opmerking</b>. Deze API zou nog kunnen uitgebreid worden met {@code orderBy}-methoden, of pagineringsmethoden,
 * of met meer ingewikkelde constructies om bijvoorbeeld een `of' in de zoekvoorwaarden op te nemen.</p>
 *
 * @author K. Coolsaet
 * @author M. van Dooren
 */
public interface PersonFinder {

    /**
     * Selecteert personen op het begin van hun familienaam
     */
    PersonFinder whereNameStartsWith(String prefix);

    /**
     * Selecteert personen op het begin van hun voornaam
     */
    PersonFinder whereFirstNameStartsWith(String prefix);

    /**
     * Selecteert personen op een deel van hun familienaam
     */
    PersonFinder whereNameContains(String fragment);

    /**
     * Geeft de lijst van resultaten terug voor de huidige selectie
     */
    Iterable<Person> getList() throws DataAccessException;

    /**
     * Geeft het aantal resultaten terug voor de huidige selectie
     */
    int getCount() throws DataAccessException;

}
