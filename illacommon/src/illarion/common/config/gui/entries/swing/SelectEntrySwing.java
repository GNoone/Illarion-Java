/*
 * This file is part of the Illarion Common Library.
 * 
 * The Illarion Common Library is free software: you can redistribute i and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * The Illarion Common Library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * the Illarion Common Library. If not, see <http://www.gnu.org/licenses/>.
 */
package illarion.common.config.gui.entries.swing;

import java.awt.Dimension;

import javax.swing.JComboBox;

import illarion.common.config.entries.ConfigEntry;
import illarion.common.config.entries.SelectEntry;
import illarion.common.config.gui.entries.SaveableEntry;

/**
 * This is a special implementation for the combo box that is initialized with a
 * configuration entry. Its sole purpose is the use along with the configuration
 * system.
 * 
 * @author Martin Karing
 * @since 1.22
 * @version 1.22
 */
public final class SelectEntrySwing extends JComboBox implements SaveableEntry {
    /**
     * The serialization UID of this text field.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The text entry used to initialize this instance.
     */
    private final SelectEntry entry;

    /**
     * Create a instance of this check entry and set the configuration entry
     * that is used to setup this class.
     * 
     * @param usedEntry the entry used to setup this class, the entry needs to
     *            pass the check with the static method
     */
    @SuppressWarnings("nls")
    public SelectEntrySwing(final ConfigEntry usedEntry) {
        if (!isUsableEntry(usedEntry)) {
            throw new IllegalArgumentException("ConfigEntry type illegal.");
        }
        entry = (SelectEntry) usedEntry;

        final String[] items = entry.getLabels();
        if (items.length > 0) {
            for (final String item : items) {
                addItem(item);
            }
            setSelectedIndex(entry.getIndex());
        }
        setMinimumSize(new Dimension(300, 10));
    }

    /**
     * Text a entry if it is usable with this class or not.
     * 
     * @param entry the entry to test
     * @return <code>true</code> in case this entry is usable with this class
     */
    public static boolean isUsableEntry(final ConfigEntry entry) {
        return (entry instanceof SelectEntry);
    }

    /**
     * Save the value in this text entry to the configuration.
     */
    @Override
    public void save() {
        entry.setValue(getSelectedIndex());
    }

}