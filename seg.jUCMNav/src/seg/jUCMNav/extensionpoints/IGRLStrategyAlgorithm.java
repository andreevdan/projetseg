/**
 * 
 */
package seg.jUCMNav.extensionpoints;

import grl.Actor;
import grl.EvaluationStrategy;
import grl.IntentionalElement;

import java.util.HashMap;

/**
 * Interface used by GRLStrategyAlgorithm. These methods should be implement to support a 
 * new strategies algorithm. It defines the evaluation calculation and the propagation algorithm
 * 
 * @author Jean-Fran�ois Roy
 *
 */
public interface IGRLStrategyAlgorithm {

    //Values for minimal value for denied, weakly denied, unknown, weakly satisficed and satisficed
    public final static int DENIED = -100;
    public final static int WDENIED = -1;
    public final static int WSATISFICED = 1;
    public final static int SATISFICED = 100;
    
    /**
     * Define the strategy to calculate the evaluation. Note that EvaluationStrategy are associated only to
     * Evaluation defined by the user. To access the list of IntentionalElement, use GRLspec (get from the strategy) 
     * 
     * @param strategy EvaluationStrategy used for the calculation 
     * @param evaluations HashMap containing the pair of IntentionalElement->Evaluation defined in this strategy. 
     */
    public void init(EvaluationStrategy strategy, HashMap evaluations);
    
    /**
     * @return true if there is a next node available for calculation
     */
    public boolean hasNextNode();
    
    /**
     * @return the next node used in the calculation
     */
    public IntentionalElement nextNode();
    

    /**
     * @param element intentionalElement to calculate the evaluation
     * @return int Evaluation of the intentionalElement between -100 and 100
     */
    public int getEvaluation(IntentionalElement element);

    /**
     * @param actor actor to calculate the evaluation
     * @return int Evaluation of the actor
     */
    public int getActorEvaluation(Actor actor);
}