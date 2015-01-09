/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Igor Zinken
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/
package nl.igorski.mmg.controller.startup;

import nl.igorski.mmg.config.Config;
import nl.igorski.mmg.definitions.Pitch;

/**
 * Created with IntelliJ IDEA.
 * User: igorzinken
 * Date: 06-01-15
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public final class CalculatePitchCommand
{
    public static void execute()
    {
        final String[] SCALE   = Config.SCALE;
        final String startNote = SCALE[ 0 ];

        int noteIndex = 0, maxIndex = SCALE.length - 1, octave = Config.MIN_OCTAVE;

        for ( int i = 0; i < SCALE.length; ++i )
        {
            if ( SCALE[ i ].equals( startNote )) {
               noteIndex = i;
               break;
            }
        }

        for ( int i = noteIndex, l = SCALE.length; i < l; ++i )
        {
            Config.pitches.add( Pitch.note( SCALE[ i ], octave ));

            if ( i == maxIndex &&
                 octave < Config.MAX_OCTAVE )
            {
                i = -1; // will be incremented by for to 0
                ++octave;
            }
        }
    }
}
